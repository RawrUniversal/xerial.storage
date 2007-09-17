/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// MinMax.java
// Since: 2004/12/27
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

/**
 * 最大値と最小値のペア
 * @author leo
 *
 */
public class MinMax<E> extends Pair<E, E>
{

    /** 最大値と最小値のペアを作成
     * @param min
     * @param max
     */
    public MinMax(E min, E max)	
    {
        super(min, max);
    }
    
    public E min() 
    {
        return getFirst();
    }
    public E max()
    {
        return getSecond();
    }

}


