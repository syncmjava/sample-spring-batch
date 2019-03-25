package jp.co.springbatch.framework.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性別VO.
 */
@AllArgsConstructor
@Getter
public enum GenderVo implements CodeVo {

  /** 男性. */
  MALE("0", "男性"),
  /** 女性. */
  FEMALE("1", "女性"),
  ;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
