/**

The Notice below must appear in each file of the Source Code of any
copy you distribute of the Licensed Product.  Contributors to any
Modifications may add their own copyright notices to identify their
own contributions.

License:

The contents of this file are subject to the CognitiveWeb Open Source
License Version 1.1 (the License).  You may not copy or use this file,
in either source code or executable form, except in compliance with
the License.  You may obtain a copy of the License from

  http://www.CognitiveWeb.org/legal/license/

Software distributed under the License is distributed on an AS IS
basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.  See
the License for the specific language governing rights and limitations
under the License.

Copyrights:

Portions created by or assigned to CognitiveWeb are Copyright
(c) 2003-2003 CognitiveWeb.  All Rights Reserved.  Contact
information for CognitiveWeb is available at

  http://www.CognitiveWeb.org

Portions Copyright (c) 2002-2003 Bryan Thompson.

Acknowledgements:

Special thanks to the developers of the Jabber Open Source License 1.0
(JOSL), from which this License was derived.  This License contains
terms that differ from JOSL.

Special thanks to the CognitiveWeb Open Source Contributors for their
suggestions and support of the Cognitive Web.

Modifications:

*/
package com.bigdata.rdf.spo;

import java.util.Comparator;

import com.bigdata.rdf.model.StatementEnum;

/**
 * Imposes s:p:o ordering based on termIds only (ignores {@link StatementEnum}).
 * 
 * @author <a href="mailto:thompsonbry@users.sourceforge.net">Bryan Thompson</a>
 * @version $Id$
 */
public class SPOComparator implements Comparator<SPO> {

    public static final transient Comparator<SPO> INSTANCE = new SPOComparator();
    
    public int compare(SPO stmt1, SPO stmt2) {

        /*
         * Note: logic avoids possible overflow of [long] by not computing the
         * difference between two longs.
         */
        int ret;
        
        ret = stmt1.s < stmt2.s ? -1 : stmt1.s > stmt2.s ? 1 : 0;
        
        if( ret == 0 ) {
        
            ret = stmt1.p < stmt2.p ? -1 : stmt1.p > stmt2.p ? 1 : 0;
            
            if( ret == 0 ) {
                
                ret = stmt1.o < stmt2.o ? -1 : stmt1.o > stmt2.o ? 1 : 0;
                
            }
            
        }

        return ret;
        
    }
    
}
