package com.gaad.infrastructure.aggr.core;

import com.gaad.infrastructure.aggr.util.AggrUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * aggregate standard data
 *
 * @param <T>
 * @author tokey
 */
public class AggrStandardData<T> extends Aggr<T> {

    /**
     * aggregate standard data
     *
     * @return
     */
    @Override
    public Object aggregate() {
        Object mainObject = null;
        try {
            checkAggrParams();
            mainObject = stack.get().get(MAIN);
            Set<Object> slaveSet = (Set) stack.get().get(SLAVE);
            Iterator<Object> iter = slaveSet.iterator();
            while (iter.hasNext()) {
                Map<String, Object> map = (Map) iter.next();
                Object slaveObject = map.get(SLAVE_ITEM);
                String slaveFileName = (String) map.get(SLAVE_ITEM_NAME);
                mainObject = AggrUtil.dynamicAddCloumn(mainObject, slaveObject, slaveFileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainObject;
    }


}

