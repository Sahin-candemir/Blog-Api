package com.springboot.blog.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
       name="posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title",nullable = false)
	private String title;
	
	@Column(name = "description",nullable = false)
	private String description;
	
	@Column(name = "content",nullable = false)
	private String content;
	
	/*
	bir post kayıt edildiği zaman ilişkili tüm commentlerde kaydedilir silindiği zaman tüm ilişkili commentlerde silinir
	CascadeType.ALL tüm özellikleri üst ögelerden alt varlıga yayar 
	orphanRemoval ilişkisiz varlık üzerinde bir işlemi tetiklememize izin verir
	*/
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)                   
	private Set<Comment> comments = new HashSet<>();     
}
