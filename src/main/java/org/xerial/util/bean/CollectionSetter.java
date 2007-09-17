/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// XerialJ
//
// CollectionSetter.java
// Since: Aug 9, 2007 9:44:18 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import org.xerial.json.InvalidJSONDataException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONException;


class CollectionSetter extends BeanBinderBase {
    Class collectionType;

    Class elementType;

    public CollectionSetter(Method method, String parameterName, Class collectionType, Class elementType) throws InvalidBeanException {
        super(method, parameterName);
        this.collectionType = collectionType;
        this.elementType = elementType;

        constractableTest(collectionType);
        constractableTest(elementType);

        assert (TypeInformation.isCollection(collectionType));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setJSONData(Object bean, Object json) throws NumberFormatException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, JSONException, InvalidBeanException, InstantiationException, InvalidJSONDataException {
        JSONArray collectionContent = getJSONArray(json, "-c");
        if (collectionContent == null)
            return;

        Collection tmpCollection = (Collection) BeanUtil.createInstance(collectionType);
        for (int i = 0; i < collectionContent.size(); i++) {
            tmpCollection.add(BeanUtil.createBean(elementType, collectionContent.get(i)));
        }
        getMethod().invoke(bean, new Object[] { tmpCollection });
    }

}
