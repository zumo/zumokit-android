// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from wallet.djinni

package money.zumo.zumokit;

/** Callback interface used by methods in @link wallet class. */
public interface SubmitTransactionCallback {
    public void onError(Exception e);

    public void onSuccess(Transaction transaction);
}
