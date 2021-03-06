package jp.co.sample.springbatch.biz.tasklet;

import jp.co.sample.common.code.DateFormat.DateFormatVo;
import jp.co.sample.common.code.GenderVo;
import jp.co.sample.common.util.LocalDateFormatUtils;
import jp.co.sample.springbatch.framework.constant.ScopeConst;
import jp.co.sample.springbatch.integration.dto.CustomerDto;
import jp.co.sample.springbatch.integration.service.SampleRestService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Sample Rest Service Client.
 */
@Scope(ScopeConst.SINGLETON)
@Service
@RequiredArgsConstructor
public class SampleRestServiceClientTasklet implements Tasklet {

  /** Sample Rest Service. (Constructor Injection) */
  private final SampleRestService service;

  /**
   * 実行.
   *
   * @param contribution {@link StepContribution}
   * @param chunkContext {@link ChunkContext}
   * @return {@link RepeatStatus} 結果ステータス
   * @throws Exception 例外
   */
  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
    // 都合上、複数の処理を１つにまとめていますが、業務用アプリでは適切にStepを分解すること

    List<CustomerDto> customers = getCustomers();

    if (!customers.isEmpty()) {
      getCustomer(customers.get(0).getCustomerNo());
    }

    // 2件INSERT→UPDATE→DELETE ※GET時にPKでOrderされていることが前提
    createCustomers();

    updateCustomers();

    deleteCustomer();

    return RepeatStatus.FINISHED;
  }

  /**
   * API:/customers, Get.
   *
   * @return {@code List<CustomerDto>} 取得結果
   */
  private List<CustomerDto> getCustomers() {
    return service.getCustomers();
  }

  /**
   * API:/customers/{customerNo}, Get.
   *
   * @param customerNo 顧客番号
   * @return {@link CustomerDto} 取得結果
   */
  private CustomerDto getCustomer(String customerNo) {
    return service.getCustomer(customerNo);
  }

  /**
   * API:/customers, Post.
   */
  private void createCustomers() {
    CustomerDto newCustomer1 = new CustomerDto();
    newCustomer1.setNameKanji("さんぷるばっち１");
    newCustomer1.setNameKana("サンプルバッチイチ");
    newCustomer1.setGender(GenderVo.MALE.getCode());
    newCustomer1.setBirthday(LocalDateFormatUtils.parse("1980-05-05", DateFormatVo.YYYYMMDD));
    newCustomer1.setAddressZip("9999999");
    newCustomer1.setAddress("埼玉県さんぷる");

    CustomerDto newCustomer2 = new CustomerDto();
    newCustomer2.setNameKanji("さんぷるばっち２");
    newCustomer2.setNameKana("サンプルバッチニ");
    newCustomer2.setGender(GenderVo.FEMALE.getCode());
    newCustomer2.setBirthday(LocalDateFormatUtils.parse("1983-11-11", DateFormatVo.YYYYMMDD));
    newCustomer2.setAddressZip("9999999");
    newCustomer2.setAddress("埼玉県さんぷる");

    List<CustomerDto> newCustomers = new ArrayList<>();
    newCustomers.add(newCustomer1);
    newCustomers.add(newCustomer2);

    // createCustomers
    service.createCustomers(newCustomers);
  }

  /**
   * API:/customers, Put.
   */
  private void updateCustomers() {
    // getCustomers
    List<CustomerDto> customers = service.getCustomers();

    List<CustomerDto> updateCustomers = new ArrayList<>();

    CustomerDto updateCustomer1 = customers.get(customers.size() - 2);
    updateCustomer1.setAddressZip("UPDATE");
    updateCustomer1.setAddress("UPDATE");
    updateCustomers.add(updateCustomer1);

    CustomerDto updateCustomer2 = customers.get(customers.size() - 1);
    updateCustomer2.setAddressZip("UPDATE");
    updateCustomer2.setAddress("UPDATE");
    updateCustomers.add(updateCustomer2);

    // updateCustomers
    service.updateCustomers(updateCustomers);
  }

  /**
   * API:/customers/{customerNo}, Delete.
   */
  private void deleteCustomer() {
    // getCustomers
    List<CustomerDto> customers = service.getCustomers();

    // deleteCustomers
    service.deleteCustomer(customers.get(customers.size() - 2).getCustomerNo());
    service.deleteCustomer(customers.get(customers.size() - 1).getCustomerNo());
  }
}
