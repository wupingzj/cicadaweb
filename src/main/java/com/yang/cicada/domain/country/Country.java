package com.yang.cicada.domain.country;

public class Country {
	// Code is the primary key
	// ISO Alpha-3 Code: http://www.nationsonline.org/oneworld/country_code_list.htm
	private String code;

	private String name;
	private String imageUrl;
	private String description;
	private boolean active;
	private boolean useState;

	public Country(String code, String name, String imageUrl, String description, boolean active, boolean useState) {
		super();
		this.code = code;
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.active = active;
		this.useState = useState;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public boolean isUseState() {
		return useState;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [code=").append(code).append(", name=").append(name).append(", imageUrl=")
		        .append(imageUrl).append(", description=").append(description).append(", active=").append(active)
		        .append(", useState=").append(useState).append("]");
		return builder.toString();
	}

}
