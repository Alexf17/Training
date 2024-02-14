package org.example.TESTING._2024_02_08_morning.mock;

public interface AuditService {
	void logNewTrade(Trade trade);
}
class SimpleAuditService implements AuditService {
	@Override
	public void logNewTrade(Trade trade) {
		throw new RuntimeException("implement logNewTrade() in SimpleAuditService");
	}
}

