package org.zstack.sdk;

import java.util.HashMap;
import java.util.Map;

public class GetBackupStorageTypesAction extends AbstractAction {

    private static final HashMap<String, Parameter> parameterMap = new HashMap<>();

    public static class Result {
        public ErrorCode error;
        public GetBackupStorageTypesResult value;
    }

    @Param(required = false)
    public java.util.List systemTags;

    @Param(required = false)
    public java.util.List userTags;

    @Param(required = true)
    public String sessionId;


    public Result call() {
        ApiResult res = ZSClient.call(this);
        Result ret = new Result();
        if (res.error != null) {
            ret.error = res.error;
            return ret;
        }
        
        GetBackupStorageTypesResult value = res.getResult(GetBackupStorageTypesResult.class);
        ret.value = value == null ? new GetBackupStorageTypesResult() : value;
        return ret;
    }

    public void call(final Completion<Result> completion) {
        ZSClient.call(this, new InternalCompletion() {
            @Override
            public void complete(ApiResult res) {
                Result ret = new Result();
                if (res.error != null) {
                    ret.error = res.error;
                    completion.complete(ret);
                    return;
                }
                
                GetBackupStorageTypesResult value = res.getResult(GetBackupStorageTypesResult.class);
                ret.value = value == null ? new GetBackupStorageTypesResult() : value;
                completion.complete(ret);
            }
        });
    }

    Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    RestInfo getRestInfo() {
        RestInfo info = new RestInfo();
        info.httpMethod = "GET";
        info.path = "/backup-storage/types";
        info.needSession = true;
        info.needPoll = false;
        info.parameterName = "";
        return info;
    }

}