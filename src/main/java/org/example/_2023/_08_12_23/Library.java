package org.example._2023._08_12_23;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    private String address;
    private long bookNumbers;
    private Book[] books;

}
