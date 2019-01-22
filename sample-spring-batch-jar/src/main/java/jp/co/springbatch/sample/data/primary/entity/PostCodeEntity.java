package jp.co.springbatch.sample.data.primary.entity;

import jp.co.springbatch.sample.common.data.entity.DbEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 郵便番号マスタEntity.
 */
// sampleではコード簡易化のためLombokを利用しますが、実装ではLombokを利用しないでください
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PostCodeEntity extends DbEntityBase {

  /** 郵便番号. */
  private String postCode;

  /** 都道府県名. */
  private String prefectureName;

  /** 市区町村名. */
  private String cityName;

  /** 町域名. */
  private String townName;

}
