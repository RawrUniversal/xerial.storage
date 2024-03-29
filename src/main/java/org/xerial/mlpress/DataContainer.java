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
// DataContainer.java
// Since: 2005/07/24 0:45:33
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.mlpress;

import org.xerial.db.VariableLengthInteger;

public interface DataContainer
{
    public void push(byte[] data, int length);
    public void push(VariableLengthInteger vli);
}
