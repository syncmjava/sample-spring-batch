package jp.co.springbatch.sample.biz.chunk.writer.callback;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jp.co.springbatch.sample.common.constant.ScopeCode;

@Scope(ScopeCode.SINGLETON)
@Component
public class WriteFooterFlatFileCallback implements FlatFileFooterCallback {

	@Override
	public void writeFooter(Writer writer) throws IOException {
		writer.write("sample footer");
	}

}