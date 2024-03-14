package com.skywhalelab.SpringBootJpa;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.skywhalelab.SpringBootJpa.TestOrg;

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
//@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
public class TestOrg {

//	@SequenceGenerator(name="TB_BOARD_SEQ", allocationSize = 1, initialValue = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_BOARD_SEQ")
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

	/*
	 * DB type-specific compatibility issues
	 * 
	 * @Column(columnDefinition = "varchar(320) default 'system' not null") private
	 * String usrId;
	 */

	/*
	 * Created so that column is [not null] and [default] is [system] However, when
	 * excluded from the input column at insert time, the [system] specified as
	 * [default] is not entered and an error occurs
	 * 
	 * @Column(length = 320, nullable = false)
	 * 
	 * @ColumnDefault("'system'") private String usrId;
	 */

	/*
	 * Created so that column is [not null] and [default] is [system] However, when
	 * excluded from the input column at insert time, the [system] specified as
	 * [default] is not entered and an error occurs
	 * 
	 * @NotNull
	 * 
	 * @Column(length = 320)
	 * 
	 * @ColumnDefault("'system'") private String usrId;
	 */

	@Column(length = 320, nullable = false)
	@ColumnDefault("'system'")
	@Builder.Default
	private String usrId = "system";

	// @Column(insertable = false, updatable = false, nullable = false,
	// columnDefinition = "datetime default sysdate()")
	@Column(insertable = false, updatable = false, nullable = false)
//	@ColumnDefault("sysdate()")
	@ColumnDefault(cmmUtil.DB_SYSDATE)
	private Date creDt;

	private Date modDt;

}