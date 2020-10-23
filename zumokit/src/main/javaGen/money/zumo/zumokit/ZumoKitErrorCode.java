// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from errors.djinni

package money.zumo.zumokit;

/**
 * The code of error returned. Some errors that could be handled programmatically (e.g., balance too low)
 * include an error code — a short string with a brief explanation — as a value for code.
 * See <a target="_top" href="https://developers.zumo.money/docs/guides/handling-errors">Handling Errors</a> for details.
 */
public final class ZumoKitErrorCode {

    /** Unknown error has occured. */
    public static final String UNKNOWN_ERROR = "unknown_error";

    /** New account could not be created. Account already exists. */
    public static final String ACCOUNT_LIMIT_EXCEEDED = "account_limit_exceeded";

    /** Could not make user fiat customer. User is already fiat customer. */
    public static final String ALREADY_FIAT_CUSTOMER = "already_fiat_customer";

    /** Requested account not found. */
    public static final String ACCOUNT_NOT_FOUND = "account_not_found";

    /** Amount not set. Either send max has to be enabled or send max set. */
    public static final String AMOUNT_NOT_SET = "amount_not_set";

    /** Invalid response received from ZumoKit API. */
    public static final String API_SERVICE_ERROR = "api_service_error";

    /** Requested change account not found. */
    public static final String CHANGE_ACCOUNT_NOT_FOUND = "change_account_not_found";

    /** Change output index out of range. */
    public static final String CHANGE_INDEX_OUT_OF_RANGE = "change_index_out_of_range";

    /**
     * Transaction data overflow.
     * Maximum data size supported by RLP encoding exceeds 16000000 bytes.
     */
    public static final String DATA_OVERFLOW = "data_overflow";

    /** Cannot set data when send max enabled. */
    public static final String DATA_PROVIDED_WHEN_SEND_MAX_SET = "data_provided_when_send_max_set";

    /** Destination cannot be set when withdrawing funds to nominated account. */
    public static final String DESTINATION_PROVIDED_WHEN_WITHDRAW_SET = "destination_provided_when_withdraw_set";

    /** Exchange amount too low. */
    public static final String EXCHANGE_AMOUNT_TOO_LOW = "exchange_amount_too_low";

    /** Exchange currencies must be different. */
    public static final String EXCHANGE_CURRENCIES_MUST_BE_DIFFERENT = "exchange_currencies_must_be_different";

    /** Exchange amount too low. Fees exceed return value. */
    public static final String EXCHANGE_RETURN_VALUE_NEGATIVE = "exchange_return_value_negative";

    /** Gas too long. Cumulative gas limit and gas price should not exceed 30 bytes. */
    public static final String GAS_OVERFLOW = "gas_overflow";

    /** Gas too low. Gas price and gas limit should be higher than 0. */
    public static final String GAS_TOO_LOW = "gas_too_low";

    /** Change account and source accounts have to be on the same network. */
    public static final String INCOMPATIBLE_NETWORK_TYPES = "incompatible_network_types";

    /**
     * Unknown error has occured
     * Incorrect account selected.
     * Account currency does not match the requeirements of requested operation.
     */
    public static final String INCORRECT_ACCOUNT_SELECTED = "incorrect_account_selected";

    /**
     * Incorrect change account selected.
     * Change account should be Bitcoin account on the same network as source account
     */
    public static final String INCORRECT_CHANGE_ACCOUNT_SELECTED = "incorrect_change_account_selected";

    /** Insufficient funds for transaction value and fee. */
    public static final String INSUFFICIENT_FUNDS = "insufficient_funds";

    /** Insufficient funds for exchange value. */
    public static final String INSUFFICIENT_FUNDS_FOR_EXCHANGE = "insufficient_funds_for_exchange";

    /** Insufficient funds for transaction value. */
    public static final String INSUFFICIENT_FUNDS_FOR_TRANSACTION = "insufficient_funds_for_transaction";

    /** Value exceeds maximum 63 bit precision. */
    public static final String INT64_OVERFLOW = "int64_overflow";

    /** Account type not supported by the operation. */
    public static final String INVALID_ACCOUNT_TYPE = "invalid_account_type";

    /** Destination address is invalid. */
    public static final String INVALID_ADDRESS = "invalid_address";

    /** Invalid response received from API. */
    public static final String INVALID_API_RESPONSE = "invalid_api_response";

    /** Invalid or missing Zumo Exchange Service address. */
    public static final String INVALID_EXCHANGE_ADDRESS = "invalid_exchange_address";

    /** Mismatch between exchange rate and selected accounts. */
    public static final String INVALID_EXCHANGE_RATE = "invalid_exchange_rate";

    /** Mismatch between exchange settings and selected accounts. */
    public static final String INVALID_EXCHANGE_SETTINGS = "invalid_exchange_settings";

    /** Invalid fee rate. Fee rate should be an integer value. */
    public static final String INVALID_FEE_RATE = "invalid_fee_rate";

    /** Requested private key derivation path is invalid. */
    public static final String INVALID_HD_WALLET_PATH = "invalid_hd_wallet_path";

    /**
     * Invalid length of mnemonic phrase.
     * Mnemonic phrase should be 12, 15, 18, 21 or 24 words long.
     */
    public static final String INVALID_MNEMONIC_WORD_COUNT = "invalid_mnemonic_word_count";

    /** Network type not supported by requested operation. */
    public static final String INVALID_NETWORK_TYPE = "invalid_network_type";

    /** "Incorrect password provided. */
    public static final String INVALID_PASSWORD = "invalid_password";

    /** "The provided recovery phrase does not correspond to existing wallet." */
    public static final String INVALID_RECOVERY_PHRASE = "invalid_recovery_phrase";

    /** Invalid transaction type. */
    public static final String INVALID_TRANSACTION_TYPE = "invalid_transaction_type";

    /** Invalid transaction value. */
    public static final String INVALID_TRANSACTION_VALUE = "invalid_transaction_value";

    /** Invalid response received from WebSocket. */
    public static final String INVALID_WEBSOCKET_RESPONSE = "invalid_websocket_response";

    /** Transaction already submitted. */
    public static final String KNOWN_TRANSACTION = "known_transaction";

    /** No destination address. In case no transaction data is provided, destination address is obligatory. */
    public static final String NO_DESTINATION_ADDRESS = "no_destination_address";

    /** No nominated account found. */
    public static final String NO_NOMINATED_ACCOUNT_FOUND = "no_nominated_account_found";

    /** Requested operation requies existance of a wallet. No wallet was found. */
    public static final String NO_WALLET_FOUND = "no_wallet_found";

    /** Nonce too long. Maximum supported nonce size is 32 bytes. */
    public static final String NONCE_OVERFLOW = "nonce_overflow";

    /** User session has expired. */
    public static final String NOT_AUTHORIZED = "not_authorized";

    /** Insufficient funds to pay the transaction fee. */
    public static final String SEND_MAX_INSUFFICIENT_FUNDS_FOR_FEE = "send_max_insufficient_funds_for_fee";

    /** Transaction amount is too small to send after the fee has been deducted. */
    public static final String SEND_MAX_INSUFFICIENT_FUNDS_FOR_TRANSACTION = "send_max_insufficient_funds_for_transaction";

    /** Something went wrong signing transaction. */
    public static final String SIGNING_ERROR = "signing_error";

    /** Transaction amount exceeds maximum precision. */
    public static final String TRANSACTION_AMOUNT_OVERFLOW = "transaction_amount_overflow";

    /** Transaction amount too small to send. */
    public static final String TRANSACTION_AMOUNT_TOO_SMALL = "transaction_amount_too_small";

    /** Invalid response received from ZumoKit Transaction Service API. */
    public static final String TRANSACTION_SERVICE_ERROR = "transaction_service_error";

    /** Resulting transaction is too large. */
    public static final String TRANSACTION_TOO_LARGE = "transaction_too_large";

    /** Fiat account could no be created. User is not yet a fiat customer on selected network. */
    public static final String USER_NOT_FIAT_CUSTOMER = "user_not_fiat_customer";

    /** Unspent transaction output could not be signed. */
    public static final String UTXO_SIGNING_ERROR = "utxo_signing_error";

    /** Cannot set amount when send max enabled. Set amount to null if trying t send maximum funds. */
    public static final String AMOUNT_PROVIDED_WHEN_SEND_MAX_SET = "amount_provided_when_send_max_set";

    /** Wallet could not be created. Wallet already exists. */
    public static final String WALLET_LIMIT_EXCEEDED = "wallet_limit_exceeded";

    /** Invalid user token set. User token set should be a valid stringified JSON with accessToken, refreshToken and expiresIn properties. */
    public static final String INVALID_USER_TOKEN_SET = "invalid_user_token_set";


    public ZumoKitErrorCode(
            ) {
    }

    @Override
    public String toString() {
        return "ZumoKitErrorCode{" +
        "}";
    }

}
