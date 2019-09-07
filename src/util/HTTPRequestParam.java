package util;

public class HTTPRequestParam {
	
	public String instanceId;
	public String topicName;
	public int partitionNum;
	public int replicNum;
	public String note;
	public int enableWhiteList;
	public String ipWhiteList;
	public String cleanUpPolicy;
	public int minInsyncReplicas;
	public int uncleanLeaderElectionEnable;
	public int retentionMs;
	public int segmentMs;
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
	public int getReplicNum() {
		return replicNum;
	}
	public void setReplicNum(int replicNum) {
		this.replicNum = replicNum;
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
	public String getIpWhiteList() {
		return ipWhiteList;
	}
	public void setIpWhiteList(String ipWhiteList) {
		this.ipWhiteList = ipWhiteList;
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
	
	

}
