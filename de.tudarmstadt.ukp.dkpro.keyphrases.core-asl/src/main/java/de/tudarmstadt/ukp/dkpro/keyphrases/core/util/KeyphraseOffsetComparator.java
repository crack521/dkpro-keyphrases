/*******************************************************************************
 * Copyright 2013
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.tudarmstadt.ukp.dkpro.keyphrases.core.util;

import java.util.Comparator;

import de.tudarmstadt.ukp.dkpro.keyphrases.core.type.Keyphrase;

public class KeyphraseOffsetComparator implements Comparator<Keyphrase> {

    public int compare(Keyphrase k1, Keyphrase k2) {
        if (k1.getBegin() < k2.getBegin()) {
            return -1;
        } else if (k1.getBegin() > k2.getBegin()) {
            return 1;
        } else {
            if (k1.getEnd() < k2.getEnd()) {
                return -1;
            }
            else if (k1.getEnd() > k2.getEnd()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}