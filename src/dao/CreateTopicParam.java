package dao;


public class CreateTopicParam {
	
	public CreateTopicParam(long timestamp, int nonce, String secretId, String signature, String instanceId,
			String topicName, int partitionNum, int replicaNum) {
		super();
		this.timestamp = timestamp;
		this.nonce = nonce;
		this.instanceId = instanceId;
		this.topicName = topicName;
		this.partitionNum = partitionNum;
		this.replicaNum = replicaNum;
	}
	public CreateTopicParam() {
		super();
	}
	
	public static final String ACTION = "CreateTopic";
	public static final String URL = "https://ckafka.api.qcloud.com/v2/index.php";
	public String region;
	public long timestamp;
	public int nonce;
	public static final String secretId="AKIDSkmY3xI1B5nFRNvZmkSxEF3i9KHzGllW";
	public  String signature;
	public String signatureMethod;
	public String token;
	public String instanceId;
	public String topicName;
	public int partitionNum;
	public int replicaNum;
	public String note;
	public int enableWhiteList;
	public String ipWhiteList_n;
	public String cleanUpPolicy;
	public int minInsyncReplicas;
	public int uncleanLeaderElectionEnable;
	public int retentionMs;
	public int segmentMs;
	public static String getAction() {
		return ACTION;
	}

	public static String getUrl() {
		return URL;
	}

	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public int getPartitionNum() {
		return partitionNum;
	}
	public void setPartitionNum(int partitionNum) {
		this.partitionNum = partitionNum;
	}
	public int getReplicaNum() {
		return replicaNum;
	}
	public void setReplicaNum(int replicaNum) {
		this.replicaNum = replicaNum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getEnableWhiteList() {
		return enableWhiteList;
	}
	public void setEnableWhiteList(int enableWhiteList) {
		this.enableWhiteList = enableWhiteList;
	}
	public String getIpWhiteList_n() {
		return ipWhiteList_n;
	}
	public void setIpWhiteList_n(String ipWhiteList_n) {
		this.ipWhiteList_n = ipWhiteList_n;
	}
	public String getCleanUpPolicy() {
		return cleanUpPolicy;
	}
	public void setCleanUpPolicy(String cleanUpPolicy) {
		this.cleanUpPolicy = cleanUpPolicy;
	}
	public int getMinInsyncReplicas() {
		return minInsyncReplicas;
	}
	public void setMinInsyncReplicas(int minInsyncReplicas) {
		this.minInsyncReplicas = minInsyncReplicas;
	}
	public int getUncleanLeaderElectionEnable() {
		return uncleanLeaderElectionEnable;
	}
	public void setUncleanLeaderElectionEnable(int uncleanLeaderElectionEnable) {
		this.uncleanLeaderElectionEnable = uncleanLeaderElectionEnable;
	}
	public int getRetentionMs() {
		return retentionMs;
	}
	public void setRetentionMs(int retentionMs) {
		this.retentionMs = retentionMs;
	}
	public int getSegmentMs() {
		return segmentMs;
	}
	public void setSegmentMs(int segmentMs) {
		this.segmentMs = segmentMs;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public String getSignatureMethod() {
		return signatureMethod;
	}
	public void setSignatureMethod(String signatureMethod) {
		this.signatureMethod = signatureMethod;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public static String getSecretid() {
		return secretId;
	}
	
	public void setSignture(String signture) {
		this.signature=signture;
	}
	public String getSignature() {
		return signature;
	}

}
