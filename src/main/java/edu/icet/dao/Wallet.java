package edu.icet.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="First name can't be blank")
    @Size(min=2,max=30)
    private String firstName;
    @NotBlank(message="Last name can't be blank")
    @Size(min=2,max=30)
    private String lastName;
    @NotBlank(message="Account number can't be blank")
    @Size(min=2,max=30)
    private String accountNumber;
    @Size(max=100)
    private String description;
    @Min(1)
    @Max(3)
    private Integer priority; //1=high; 2=Medium; 3=Low
    private Double currentBalance;
    @PrePersist
    public void setBalance(){
        this.currentBalance=0.00;
    }
}
