package me.sailer.my_atelier.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class MemberAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short addressNo;

    private Member memberNo;

    private String name;

    private String address;

    private String receiveName;

    private String receivePhone;
}
