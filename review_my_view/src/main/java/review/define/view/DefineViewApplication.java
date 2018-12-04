package review.define.view;

import com.qsmaxmin.qsbase.QsApplication;
import com.qsmaxmin.qsbase.common.http.HttpBuilder;

/**
 * Created by fcl on 18.12.4
 * desc:
 */

public class DefineViewApplication extends QsApplication {

    @Override
    public boolean isLogOpen() {
        return false;
    }

    @Override
    public void initHttpAdapter(HttpBuilder builder) {

    }
}
