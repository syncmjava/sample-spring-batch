package jp.co.springbatch.framework.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * レコード種別VO.
 */
@AllArgsConstructor
@Getter
public enum RecodeTypeVo implements CodeVo {

  /** ヘッダーレコード. */
  HEADER_RECODE("01", "ヘッダーレコード"),
  /** データレコード. */
  DATA_RECODE("02", "データレコード"),
  /** トレーラレコード. */
  TRAILER_RECORD("03", "トレーラレコード"),
  ;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
