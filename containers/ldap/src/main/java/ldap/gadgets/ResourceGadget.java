package ldap.gadgets;

import ldap.MarshallerBase;
import ldap.UtilFactory;

public interface ResourceGadget extends Gadget{
    @Args ( minArgs = 1, args = {
            "codebase"
    }, defaultArgs = {
            MarshallerBase.defaultCodebase
    } )
    Object makeResource (UtilFactory uf, String[] args ) throws Exception;
}
