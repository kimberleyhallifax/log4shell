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


import org.apache.mina.core.buffer.IoBuffer;
import org.red5.io.amf.Input;

import flex.messaging.io.SerializationContext;
import flex.messaging.io.amf.AbstractAmfOutput;
import flex.messaging.io.amf.Amf0Output;


/**
 * @author mbechler
 *
 */
public class Red5AMF0 extends Red5AMFBase {

    /**
     * {@inheritDoc}
     *
     * @see ldap.Red5AMFBase#createInput(org.apache.mina.core.buffer.IoBuffer)
     */
    @Override
    protected Input createInput ( IoBuffer buf ) {
        return new org.red5.io.amf.Input(buf);
    }


    /**
     * {@inheritDoc}
     *
     * @see ldap.BlazeDSBase#createOutput(flex.messaging.io.SerializationContext)
     */
    @Override
    protected AbstractAmfOutput createOutput ( SerializationContext sc ) {
        return new Amf0Output(sc);
    }


    public static void main ( String[] args ) {
        new Red5AMF0().run(args);
    }
}
