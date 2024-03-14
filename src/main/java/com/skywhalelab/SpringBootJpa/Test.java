package com.skywhalelab.SpringBootJpa;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.skywhalelab.SpringBootJpa.Test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
public class Test {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long seq;

	@Column(length = 8)
	@ColumnDefault("'NONE'")
	private String bbsCd;

	@Column(length = 128)
	private String title;

	@Lob
	private String content;

	private Long uprSeq;

	@Column(insertable = false, nullable = false)
	@ColumnDefault("0")
	private Integer rdCnt;

	@Column(length = 2)
	@ColumnDefault("0")
	private Integer dth;

	@Column(length = 1, insertable = false, nullable = false)
	@ColumnDefault("'N'")
	private String delYn;

	@Column(length = 320, nullable = false)
	@ColumnDefault("'system'")
	private String usrId;

	@Column(insertable = false, updatable = false, nullable = false)
	@ColumnDefault(cmmUtil.DB_SYSDATE)
	private Date creDt;

	private Date modDt;

}