package oct19;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import oct18.CommonLogger;

public class ProfileFilter implements Filter {

	private CommonLogger commonLogger;

	@Override
	public void destroy() {
		commonLogger.log("ProfileFilter.destroy() 호출됨");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		long start = System.currentTimeMillis();
		try {
			filterChain.doFilter(request, response);
		} finally {
			long finish = System.currentTimeMillis();
			commonLogger.log("실행 시간 : " + (finish - start));
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		commonLogger.log("ProfileFilter.init() 호출됨");
	}

	public void setCommonLogger(CommonLogger commonLogger) {
		this.commonLogger = commonLogger;
	}

}