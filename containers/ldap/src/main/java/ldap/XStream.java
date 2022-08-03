/* MIT License

Copyright (c) 2017 Moritz Bechler

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package ldap;


import java.util.Comparator;

import ldap.gadgets.BindingEnumeration;
import ldap.gadgets.CommonsBeanutils;
import ldap.gadgets.CommonsConfiguration;
import ldap.gadgets.ImageIO;
import ldap.gadgets.JDKUtil;
import ldap.gadgets.LazySearchEnumeration;
import ldap.gadgets.Resin;
import ldap.gadgets.Rome;
import ldap.gadgets.ServiceLoader;
import ldap.gadgets.SpringAbstractBeanFactoryPointcutAdvisor;
import ldap.gadgets.SpringPartiallyComparableAdvisorHolder;
import ldap.gadgets.XBean;


/**
 * 
 * Not applicable:
 * - UnicastRefGadget,UnicastRemoteObjectGadget: don't think there is anything to gain here
 * 
 * @author mbechler
 *
 */
public class XStream extends MarshallerBase<String> implements CommonsConfiguration, Rome, CommonsBeanutils, ServiceLoader, ImageIO,
        BindingEnumeration, LazySearchEnumeration, SpringAbstractBeanFactoryPointcutAdvisor, SpringPartiallyComparableAdvisorHolder, Resin, XBean {

    /**
     * {@inheritDoc}
     *
     * @see ldap.MarshallerBase#marshal(java.lang.Object)
     */
    @Override
    public String marshal ( Object o ) throws Exception {
        com.thoughtworks.xstream.XStream xs = new com.thoughtworks.xstream.XStream();
        return xs.toXML(o);
    }


    /**
     * {@inheritDoc}
     *
     * @see ldap.MarshallerBase#unmarshal(java.lang.Object)
     */
    @Override
    public Object unmarshal ( String data ) throws Exception {
        com.thoughtworks.xstream.XStream xs = new com.thoughtworks.xstream.XStream();
        return xs.fromXML(data);
    }


    /**
     * {@inheritDoc}
     *
     * @see ldap.UtilFactory#makeComparatorTrigger(java.lang.Object, java.util.Comparator)
     */
    @Override
    public Object makeComparatorTrigger ( Object tgt, Comparator<?> cmp ) throws Exception {
        return JDKUtil.makePriorityQueue(tgt, cmp);
    }


    public static void main ( String[] args ) {
        new XStream().run(args);
    }
}
