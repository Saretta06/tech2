package com.example;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

@Component
public class EventiJDBCTemplate {
	
    private JdbcTemplate jdbcTemplateObject;
   

    @Autowired
    public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
        this.jdbcTemplateObject = jdbcTemplateObject;
    }
    
    public int insert(String nome, String tipologia, double prezzo, int postiD, LocalDate data, String url) {
    System.out.println("Inserendo dati: " + nome + ", " + tipologia + ", " + prezzo + ", " + postiD + ", " + data + ", " + url);
    String query = "INSERT INTO eventi (nome, tipologia, prezzo, postiD, data, url) VALUES (?, ?, ?, ?, ?, ?)";
    return jdbcTemplateObject.update(query, nome, tipologia, prezzo, postiD, data, url);
}
    
    public int delete(String nome) {
    System.out.println("Cancellando dati per nome: " + nome);
    String query = "DELETE FROM eventi WHERE nome = ?";
    return jdbcTemplateObject.update(query, nome);
}

    public ArrayList<Eventi> getLista() {

        String query = "SELECT * FROM eventi";
        return jdbcTemplateObject.query(query, new ResultSetExtractor<ArrayList<Eventi>>() {
            //metodo astratto;
            @Override
            public ArrayList<Eventi> extractData(ResultSet rs) throws SQLException, DataAccessException {
                //creiamo un arrayList per farglielo poi restituire;
                ArrayList<Eventi> ListaEventi = new ArrayList<>();
                //iteriamo il result set con l'arrayList
                while (rs.next()) {

                    Eventi e1 = new Eventi();

                    e1.setNome(rs.getString("nome"));
                    e1.setTipologia(rs.getString("tipologia"));
                    e1.setPrezzo(rs.getDouble("prezzo"));
                    e1.setPostiD(rs.getInt("postiD"));
                    e1.setUrl(rs.getString("url"));

                   //data da stringa
                    String dataStr = rs.getString("data");
                    e1.setData(dataStr);
                   

                    ListaEventi.add(e1);                    
                }
                return ListaEventi;
            }
        });
    }
    
    
    
}
