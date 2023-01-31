package test_practice;

import lombok.Data;

@Data
public class RoleMst {
	private int roleId;
	private String roleName;
	
	private RoleMst(Builder bulider) {
		this.roleId = bulider.roleId;
		this.roleName = bulider.roleName;
		}

	public static Builder bulider() {
		return new Builder();
		}

	public static class Builder {
		private int roleId;
		private String roleName;
	
		private Builder(){}
	
	public Builder roleId(int roleId) {
		this.roleId = roleId;
		return this;
		}
	
	public Builder roleName(String roleName) {
		this.roleName = roleName;
		return this;
		}
	
	public RoleMst build() {
		return new RoleMst(this);
		}
	
	}

}