package com.ayman.nindemo.model.entity;

import com.ayman.nindemo.validation.annotation.ValidateNin;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "valid_nins")
public class NIN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @ValidateNin
    private String nin;
}
