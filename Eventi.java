

package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Eventi {
    
    private int id;
    private String nome;
    private String tipologia;
    private double prezzo;
    private int postiD;
    private LocalDate data;
    private String url;
    
    // Metodo per impostare la data da una stringa
    public void setData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.data = LocalDate.parse(data, formatter);
    }


}
