package com.example.bookmanage.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author tangzhu
 * @date 2020/3/12 10:32 下午
 */
@Data
@Table(name = "tb_books")
public class Book {
    @KeySql(useGeneratedKeys = true)
    @Id
    @Column(name = "id")
    private Long id; // id
    @Column(name = "book_floor")
    private Integer floor; // 楼层
    @Column(name = "book_room")
    private String room; // 房间
    @Column(name = "book_row")
    private Integer row; // 书架（排）
    @Column(name = "book_col")
    private Integer col; // 书架（列）
    @Column(name = "book_shelf")
    private Integer bookshelfFloor; // 书架（第几层）
    @Column(name = "book_label")
    private String label; // 分类
    @Column(name = "book_name")
    private String name; // 书名
    @Column(name = "book_press")
    private String press; // 出版社
    @Column(name = "book_desc")
    private String description; // 描述信息
    @Column(name = "book_author")
    private String author; // 作者
    @Column(name = "creat_time")
    private Date createdTime; // 创建日期
    @Column(name = "edit_time")
    private Date editTime; // 修改日期
}
