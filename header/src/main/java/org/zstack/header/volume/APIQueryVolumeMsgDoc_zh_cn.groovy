package org.zstack.header.volume

import org.zstack.header.query.APIQueryMessage

doc {
    title "获取云盘清单(QueryVolume)"

    category "volume"

    desc "获取云盘清单"

    rest {
        request {
			url "GET /v1/volmes"

			url "GET /v1/volumes/{uuid}"


            header (OAuth: 'the-session-uuid')

            clz APIQueryVolumeMsg.class

            desc ""
            
			params APIQueryMessage.class
        }

        response {
            clz APIQueryVolumeReply.class
        }
    }
}