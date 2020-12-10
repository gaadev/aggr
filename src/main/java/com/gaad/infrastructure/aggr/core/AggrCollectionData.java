package com.gaad.infrastructure.aggr.core;

import com.gaad.infrastructure.aggr.util.AggrUtil;

import java.util.*;

/**
 * aggregate collection data
 * @author tokey
 * @param <T>
 */
public class AggrCollectionData<T> extends Aggr<T> {


    /**
     * aggregate collection data
     * @return
     */
    @Override
    public Object aggregate() {
        List<T> mainList = null;
        try {
            checkAggrParams();
            mainList = (List) stack.get().get(MAIN);
            List<String> mainIdFiledNames = (List) stack.get().get(MAIN_ID_FIELD_NAME);
            Set<Object> slaveSet = (Set) stack.get().get(SLAVE);
            Iterator<Object> iter = slaveSet.iterator();
            while (iter.hasNext()) {
                Map<String, Object> map = (Map) iter.next();
                Object slaveList = map.get(SLAVE_ITEM);
                List<String> slaveIdFileNames = (List) map.get(SLAVE_ID_FIELD_NAME);
                if (slaveIdFileNames.size() != mainIdFiledNames.size()) {
                    throw new RuntimeException("Aggr: list copy list ,mainIdFiledNames and slaveIdFileNames is unequal length");
                }
                String slaveFileName = (String) map.get(SLAVE_ITEM_NAME);
                if (slaveList instanceof Collection) {
                    mainList = AggrUtil.copy(mainList, mainIdFiledNames, (Collection<?>) slaveList, slaveIdFileNames, slaveFileName);
                    continue;
                }
                throw new RuntimeException("Aggr: list copy list ,slave object is not list type");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return mainList;
    }





}

