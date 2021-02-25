package it.academy.pojo;


import it.academy.util.AddDuringScan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@AddDuringScan
public class Email implements Emaill {

    private Long id;
    private String login;
    private String password;

}
