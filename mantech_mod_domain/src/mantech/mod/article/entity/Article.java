/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.article.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author NGUYEN
 */
@Entity
@Table(name = "Article", catalog = "Mantech", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Article.collectNewsArticle", query = "SELECT a FROM Article a Order By a.createdDate DESC"),
    @NamedQuery(name = "Article.findById", query = "SELECT a FROM Article a WHERE a.id = :id"),

    @NamedQuery(name = "Article.findByArticle", query = "SELECT a FROM Article a WHERE a.article = :article"),
    @NamedQuery(name = "Article.findByLikeArticle", query = "SELECT a FROM Article a WHERE a.article like :article Order By a.createdDate DESC"),
    @NamedQuery(name = "Article.findByLikeArticleContant", query = "SELECT a FROM Article a WHERE a.article like :contentString or a.content like :contentString Order By a.createdDate DESC"),

    @NamedQuery(name = "Article.findByCreatedDate", query = "SELECT a FROM Article a WHERE a.createdDate = :createdDate"),
    @NamedQuery(name = "Article.findBetweenCreatedDate", query = "SELECT a FROM Article a WHERE a.createdDate BETWEEN :date1 AND :date2 Order By a.createdDate DESC"),
    @NamedQuery(name = "Article.findAfterCreatedDate", query = "SELECT a FROM Article a WHERE a.createdDate >= :createdDate Order By a.createdDate DESC"),

    @NamedQuery(name = "Article.findByRate", query = "SELECT a FROM Article a WHERE a.rate = :rate Order By a.createdDate DESC"),
    @NamedQuery(name = "Article.findByHigherRate", query = "SELECT a FROM Article a WHERE a.rate >= :rate Order By a.createdDate DESC"),
    @NamedQuery(name = "Article.findByThumbnail", query = "SELECT a FROM Article a WHERE a.thumbnail = :thumbnail")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Article", nullable = false, length = 50)
    private String article;
    @Basic(optional = false)
    @Lob
    @Column(name = "Content", nullable = false, length = 2147483647)
    private String content;
    @Basic(optional = false)
    @Column(name = "CreatedDate", nullable = false)
    private Date createdDate;
    @Column(name = "Rate")
    private Integer rate;
    @Column(name = "Thumbnail", length = 50)
    private String thumbnail;

    public Article() {
    }

    public Article(Integer id) {
        this.id = id;
    }

    public Article(Integer id, String article, String content, Date createdDate) {
        this.id = id;
        this.article = article;
        this.content = content;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mantech.mod.article.entity.Article[id=" + id + "]";
    }

}
