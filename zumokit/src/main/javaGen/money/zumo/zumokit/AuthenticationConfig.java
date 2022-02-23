// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

import java.util.ArrayList;

/** Record containing Strong Customer Authentication (SCA) config */
public final class AuthenticationConfig {


    /*package*/ final ArrayList<KbaQuestion> mKnowledgeBase;

    public AuthenticationConfig(
            ArrayList<KbaQuestion> knowledgeBase) {
        this.mKnowledgeBase = knowledgeBase;
    }

    /** Knowledge-Based Authentication (KBA) questions. */
    public ArrayList<KbaQuestion> getKnowledgeBase() {
        return mKnowledgeBase;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticationConfig)) {
            return false;
        }
        AuthenticationConfig other = (AuthenticationConfig) obj;
        return this.mKnowledgeBase.equals(other.mKnowledgeBase);
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mKnowledgeBase.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "AuthenticationConfig{" +
                "mKnowledgeBase=" + mKnowledgeBase +
        "}";
    }

}
