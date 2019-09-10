package dao;

public class ListTopicDao {

	public ListTopicDao(String instanceId, String searchWord, int offset, int limit) {
		super();
		this.instanceId = instanceId;
		this.searchWord = searchWord;
		this.offset = offset;
		this.limit = limit;
	}
	public String instanceId;
	public String searchWord;
	public Integer offset;
	public Integer limit;
	public String Action="DescribeInstances";
	public String Region;
	public int Timestamp;
	public int Nonce;
	public String SecretId="AKIDSkmY3xI1B5nFRNvZmkSxEF3i9KHzGllW";
	public String Signature;
	public String SignatureMethod="HmacSHA256";
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	public String getSecretId() {
		return SecretId;
	}
	public void setSecretId(String secretId) {
		SecretId = secretId;
	}
	public String getSignatureMethod() {
		return SignatureMethod;
	}
	public void setSignatureMethod(String signatureMethod) {
		SignatureMethod = signatureMethod;
	}
	public String Token;
	
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public ListTopicDao() {
		super();
	}
	public ListTopicDao(String instanceId) {
		super();
		this.instanceId = instanceId;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public int getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(int timestamp) {
		Timestamp = timestamp;
	}
	public int getNonce() {
		return Nonce;
	}
	public void setNonce(int nonce) {
		Nonce = nonce;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	
	

}
