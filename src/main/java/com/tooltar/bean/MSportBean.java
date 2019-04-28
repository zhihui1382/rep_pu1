package com.tooltar.bean;

import java.util.Date;

/***
 * 前端用户运动实体类
 *
 */
public class MSportBean {
	
	private Integer id;
	private Integer mu_id;
	private Integer kcal;
	private Integer mileage;
	private Integer duration;
	private Double speed;
	private Date start_time;
	
	@Override
	public String toString() {
		return "MSportBean [id=" + id + ", mu_id=" + mu_id + ", kcal=" + kcal + ", mileage=" + mileage + ", duration="
				+ duration + ", speed=" + speed + ", start_time=" + start_time + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kcal == null) ? 0 : kcal.hashCode());
		result = prime * result + ((mileage == null) ? 0 : mileage.hashCode());
		result = prime * result + ((mu_id == null) ? 0 : mu_id.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
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
		MSportBean other = (MSportBean) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kcal == null) {
			if (other.kcal != null)
				return false;
		} else if (!kcal.equals(other.kcal))
			return false;
		if (mileage == null) {
			if (other.mileage != null)
				return false;
		} else if (!mileage.equals(other.mileage))
			return false;
		if (mu_id == null) {
			if (other.mu_id != null)
				return false;
		} else if (!mu_id.equals(other.mu_id))
			return false;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		if (start_time == null) {
			if (other.start_time != null)
				return false;
		} else if (!start_time.equals(other.start_time))
			return false;
		return true;
	}
	public MSportBean() {
		super();
	}
	public MSportBean(Integer id, Integer mu_id, Integer kcal, Integer mileage, Integer duration, Double speed,
			Date start_time) {
		super();
		this.id = id;
		this.mu_id = mu_id;
		this.kcal = kcal;
		this.mileage = mileage;
		this.duration = duration;
		this.speed = speed;
		this.start_time = start_time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMu_id() {
		return mu_id;
	}
	public void setMu_id(Integer mu_id) {
		this.mu_id = mu_id;
	}
	public Integer getKcal() {
		return kcal;
	}
	public void setKcal(Integer kcal) {
		this.kcal = kcal;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	
}
