package beans;

public class BaseBean {

	private String name, description, notes1, notes2, notes3, notes4, notes5, notes6, notes7, notes8, notes9, notes10,
			notes11, notes12, notes13, num1, num2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes1() {
		return notes1;
	}

	public void setNotes1(String notes1) {
		this.notes1 = notes1;
	}

	public String getNotes2() {
		return notes2;
	}

	public void setNotes2(String notes2) {
		this.notes2 = notes2;
	}

	public String getNotes3() {
		return notes3;
	}

	public void setNotes3(String notes3) {
		this.notes3 = notes3;
	}

	public String getNotes4() {
		return notes4;
	}

	public void setNotes4(String notes4) {
		this.notes4 = notes4;
	}

	public String getNotes5() {
		return notes5;
	}

	public void setNotes5(String notes5) {
		this.notes5 = notes5;
	}

	public String getNotes6() {
		return notes6;
	}

	public void setNotes6(String notes6) {
		this.notes6 = notes6;
	}

	public String getNotes7() {
		return notes7;
	}

	public void setNotes7(String notes7) {
		this.notes7 = notes7;
	}

	public String getNotes8() {
		return notes8;
	}

	public void setNotes8(String notes8) {
		this.notes8 = notes8;
	}

	public String getNotes9() {
		return notes9;
	}

	public void setNotes9(String notes9) {
		this.notes9 = notes9;
	}

	public String getNotes10() {
		return notes10;
	}

	public void setNotes10(String notes10) {
		this.notes10 = notes10;
	}

	public String getNotes11() {
		return notes11;
	}

	public void setNotes11(String notes11) {
		this.notes11 = notes11;
	}

	public String getNotes12() {
		return notes12;
	}

	public void setNotes12(String notes12) {
		this.notes12 = notes12;
	}

	public String getNotes13() {
		return notes13;
	}

	public void setNotes13(String notes13) {
		this.notes13 = notes13;
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes1 == null) ? 0 : notes1.hashCode());
		result = prime * result + ((notes10 == null) ? 0 : notes10.hashCode());
		result = prime * result + ((notes11 == null) ? 0 : notes11.hashCode());
		result = prime * result + ((notes12 == null) ? 0 : notes12.hashCode());
		result = prime * result + ((notes13 == null) ? 0 : notes13.hashCode());
		result = prime * result + ((notes2 == null) ? 0 : notes2.hashCode());
		result = prime * result + ((notes3 == null) ? 0 : notes3.hashCode());
		result = prime * result + ((notes4 == null) ? 0 : notes4.hashCode());
		result = prime * result + ((notes5 == null) ? 0 : notes5.hashCode());
		result = prime * result + ((notes6 == null) ? 0 : notes6.hashCode());
		result = prime * result + ((notes7 == null) ? 0 : notes7.hashCode());
		result = prime * result + ((notes8 == null) ? 0 : notes8.hashCode());
		result = prime * result + ((notes9 == null) ? 0 : notes9.hashCode());
		result = prime * result + ((num1 == null) ? 0 : num1.hashCode());
		result = prime * result + ((num2 == null) ? 0 : num2.hashCode());
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
		BaseBean other = (BaseBean) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes1 == null) {
			if (other.notes1 != null)
				return false;
		} else if (!notes1.equals(other.notes1))
			return false;
		if (notes10 == null) {
			if (other.notes10 != null)
				return false;
		} else if (!notes10.equals(other.notes10))
			return false;
		if (notes11 == null) {
			if (other.notes11 != null)
				return false;
		} else if (!notes11.equals(other.notes11))
			return false;
		if (notes12 == null) {
			if (other.notes12 != null)
				return false;
		} else if (!notes12.equals(other.notes12))
			return false;
		if (notes13 == null) {
			if (other.notes13 != null)
				return false;
		} else if (!notes13.equals(other.notes13))
			return false;
		if (notes2 == null) {
			if (other.notes2 != null)
				return false;
		} else if (!notes2.equals(other.notes2))
			return false;
		if (notes3 == null) {
			if (other.notes3 != null)
				return false;
		} else if (!notes3.equals(other.notes3))
			return false;
		if (notes4 == null) {
			if (other.notes4 != null)
				return false;
		} else if (!notes4.equals(other.notes4))
			return false;
		if (notes5 == null) {
			if (other.notes5 != null)
				return false;
		} else if (!notes5.equals(other.notes5))
			return false;
		if (notes6 == null) {
			if (other.notes6 != null)
				return false;
		} else if (!notes6.equals(other.notes6))
			return false;
		if (notes7 == null) {
			if (other.notes7 != null)
				return false;
		} else if (!notes7.equals(other.notes7))
			return false;
		if (notes8 == null) {
			if (other.notes8 != null)
				return false;
		} else if (!notes8.equals(other.notes8))
			return false;
		if (notes9 == null) {
			if (other.notes9 != null)
				return false;
		} else if (!notes9.equals(other.notes9))
			return false;
		if (num1 == null) {
			if (other.num1 != null)
				return false;
		} else if (!num1.equals(other.num1))
			return false;
		if (num2 == null) {
			if (other.num2 != null)
				return false;
		} else if (!num2.equals(other.num2))
			return false;
		return true;
	}

}
