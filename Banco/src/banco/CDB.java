/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author eduardo.schneider
 */
public class CDB {

    private int id;
    private String nome;
    private BigDecimal saldo;
    private Date vencimento;
    private BigDecimal porcentagemCDI;

    public CDB(int id, String nome, BigDecimal saldo, Date data, BigDecimal porcentagemCDI) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        this.vencimento = data;
        this.porcentagemCDI = porcentagemCDI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getVencimento() {
        return vencimento;
    }
    
    public String getVencimentoString() throws ParseException {
        DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str = targetFormat.format(vencimento);
        
        return str;
    }
    

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public BigDecimal getPorcentagemCDI() {
        return porcentagemCDI;
    }

    public void setPorcentagemCDI(BigDecimal porcentagemCDI) {
        this.porcentagemCDI = porcentagemCDI;
    }
    
    public static void depositarCDB(String codigoCDB, Double valor) throws SQLException{
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();   
        
        String insert = "INSERT INTO cdb_extrato(cdb,cliente,saldo,status)"
                        + " VALUES (" + codigoCDB +"," + Cliente.logado.getIdCliente() + "," + valor + "," + 1 + ");";
        System.out.println(insert);
        stmt.execute(insert);
        
        String updateConta = "UPDATE conta SET saldo = saldo -"+ valor +"WHERE id = " + Conta.logado.getIdConta();
        stmt.execute(updateConta);
        
        String juntaTodosOsDepositos ="SELECT * FROM cdb_extrato WHERE cdb = " + codigoCDB;
        System.out.println(juntaTodosOsDepositos);
        stmt.executeQuery(juntaTodosOsDepositos);
        ResultSet resultSet2 = stmt.getResultSet();
        Double saldoTotal = 0.0;
        
        while(resultSet2.next()){
            saldoTotal += resultSet2.getDouble("saldo");
        }

        String update = "UPDATE cdb SET saldo = " + saldoTotal + " WHERE id = " + codigoCDB;
        System.out.println(update);
        stmt.execute(update);
        
        con2.close();
    }
    
    public static void atualizaSaldoTotal(String codigoCDB) throws SQLException {
        
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  
        String juntaTodosOsDepositos ="SELECT * FROM cdb_extrato WHERE cdb = " + codigoCDB;
        System.out.println(juntaTodosOsDepositos);
        stmt.executeQuery(juntaTodosOsDepositos);
        ResultSet resultSet2 = stmt.getResultSet();
        Double saldoTotal = 0.0;

        while(resultSet2.next()){
            saldoTotal += resultSet2.getDouble("saldo");
        }

        String update = "UPDATE cdb SET saldo = " + saldoTotal + " WHERE id = " + codigoCDB;
        stmt.execute(update);
        
        con2.close();
    }
    
    public static void verificaJurosBD() throws SQLException {
       Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
       Statement stmt = (Statement)con2.createStatement();
       String consulta ="SELECT data FROM hoje WHERE id = 1";
       ResultSet resultSet = stmt.executeQuery(consulta);
       LocalDate hoje = null;
        while (resultSet.next()){
           hoje = resultSet.getDate("data").toLocalDate();
        }
       int month = hoje.getMonthValue();
       Taxas taxas = new Taxas();
       Double taxaAtual;
       
       if (month >= 7){
            taxaAtual = taxas.getSelicMensal()[month - 7];
            if ((taxas.getSelicAnual()[month - 7]).compareTo(8.5) < 0)
                taxaAtual = (taxas.getCdiDiario()[month - 7]);
        } else 
        {
            taxaAtual = taxas.getSelicMensal()[month + 5];
            if ((taxas.getSelicAnual()[month + 5]).compareTo(8.5) < 0)
                taxaAtual = (taxas.getCdiDiario()[month + 5]);
        }
       
       String pegaMovimentos = "SELECT * FROM cdb_extrato";
       ResultSet resultSet2 = stmt.executeQuery(pegaMovimentos);
       
        while (resultSet2.next()){
           int status = resultSet2.getInt("status");
           String codigoCDB = resultSet2.getInt("cdb") + "";
           Statement stmtx = (Statement)con2.createStatement();
           String pegaPorcentagem = " SELECT porcentagem FROM cdb WHERE id = " + resultSet2.getInt("cdb");
           ResultSet resultSetx = stmtx.executeQuery(pegaPorcentagem);
           int porcentagem = 0;
           while (resultSetx.next()){
                 porcentagem = resultSetx.getInt("porcentagem");
           }
            System.out.println(porcentagem);
           if (status == 1){
                Statement stmt2 = (Statement)con2.createStatement();
                String update3 = "UPDATE cdb_extrato SET saldo = saldo + (saldo * (" + taxaAtual / 100 + ") * " + porcentagem * 0.01 + ")";
                System.out.println(update3);
                stmt2.execute(update3);
               }
           atualizaSaldoTotal(codigoCDB);
           }
        //
            
           String destruidor = "SELECT * FROM cdb WHERE vencimento = 0;";
           ResultSet lalala = stmt.executeQuery(destruidor);
            
           while (lalala.next()){
              Statement stmt3 = (Statement)con2.createStatement();
              String destruidor2 = "SELECT * FROM cdb_extrato WHERE cdb = " + lalala.getInt("id") + ";";
              ResultSet lalala2 = stmt3.executeQuery(destruidor2);
              while (lalala2.next()){
                    Statement stmt4 = (Statement)con2.createStatement();
                    String destruidor3 = "SELECT * FROM conta WHERE cliente = " + lalala2.getInt("cliente") + ";";
                    ResultSet lalala3 = stmt4.executeQuery(destruidor3);
                    int idConta = 0;
                    while(lalala3.next()){
                        idConta = lalala3.getInt("id");
                    }

                    String depositador = "UPDATE conta SET saldo = saldo + " + lalala2.getDouble("saldo") + " WHERE id = " + idConta + ";";
                    stmt4.execute(depositador);
                    String demolidor = "DELETE FROM cdb_extrato WHERE id = " + lalala2.getInt("id");
                    stmt4.execute(demolidor);
              }
           }
            
           Statement stmt5 = (Statement)con2.createStatement();
           String demolidor2 = "DELETE FROM cdb WHERE vencimento = 0";
           stmt5.execute(demolidor2);
           con2.close();
        }

}
