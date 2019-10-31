package com.terawarehouse.data.entity.trading;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.broodcamp.data.entity.BaseEntity;
import com.terawarehouse.data.entity.crm.Staff;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Entity
@Table(name = "trading_staff_branch")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class TradingStaffBranch extends BaseEntity {

    private static final long serialVersionUID = -325621024732559227L;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false, updatable = false)
    private Staff staff;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "trading_branch_id", nullable = false, updatable = false)
    private TradingBranch tradingBranch;
}
