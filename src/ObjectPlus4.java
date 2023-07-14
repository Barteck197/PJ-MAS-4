public abstract class ObjectPlus4 extends ObjectPlusPlus {

    public ObjectPlus4() {
        super();
    }

    public void addLink_subset(String roleName, String reverseRoleName, String superRoleName, ObjectPlusPlus targetObject) throws Exception {
        if (isLink(superRoleName, targetObject)) {
            // There is a (super) link to the added object in the super role
            // Create the link
            addLink(roleName, reverseRoleName, targetObject);
        } else {
            // No super link ==> exception
            throw new Exception("No link to the '" + targetObject + "' object in the '" + superRoleName + "' super role!");
        }
    }
}