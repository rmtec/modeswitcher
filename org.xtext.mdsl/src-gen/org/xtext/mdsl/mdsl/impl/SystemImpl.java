/**
 * generated by Xtext 2.25.0
 */
package org.xtext.mdsl.mdsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.xtext.mdsl.mdsl.MdslPackage;
import org.xtext.mdsl.mdsl.Mode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.SystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.SystemImpl#getModes <em>Modes</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.SystemImpl#getDistribution <em>Distribution</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.SystemImpl#getReleaseDate <em>Release Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImpl extends DeclarationImpl implements org.xtext.mdsl.mdsl.System
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getModes() <em>Modes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModes()
   * @generated
   * @ordered
   */
  protected EList<Mode> modes;

  /**
   * The default value of the '{@link #getDistribution() <em>Distribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDistribution()
   * @generated
   * @ordered
   */
  protected static final String DISTRIBUTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDistribution() <em>Distribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDistribution()
   * @generated
   * @ordered
   */
  protected String distribution = DISTRIBUTION_EDEFAULT;

  /**
   * The default value of the '{@link #getReleaseDate() <em>Release Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReleaseDate()
   * @generated
   * @ordered
   */
  protected static final String RELEASE_DATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReleaseDate() <em>Release Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReleaseDate()
   * @generated
   * @ordered
   */
  protected String releaseDate = RELEASE_DATE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SystemImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MdslPackage.Literals.SYSTEM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.SYSTEM__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Mode> getModes()
  {
    if (modes == null)
    {
      modes = new EObjectResolvingEList<Mode>(Mode.class, this, MdslPackage.SYSTEM__MODES);
    }
    return modes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDistribution()
  {
    return distribution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDistribution(String newDistribution)
  {
    String oldDistribution = distribution;
    distribution = newDistribution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.SYSTEM__DISTRIBUTION, oldDistribution, distribution));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getReleaseDate()
  {
    return releaseDate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReleaseDate(String newReleaseDate)
  {
    String oldReleaseDate = releaseDate;
    releaseDate = newReleaseDate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.SYSTEM__RELEASE_DATE, oldReleaseDate, releaseDate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MdslPackage.SYSTEM__NAME:
        return getName();
      case MdslPackage.SYSTEM__MODES:
        return getModes();
      case MdslPackage.SYSTEM__DISTRIBUTION:
        return getDistribution();
      case MdslPackage.SYSTEM__RELEASE_DATE:
        return getReleaseDate();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MdslPackage.SYSTEM__NAME:
        setName((String)newValue);
        return;
      case MdslPackage.SYSTEM__MODES:
        getModes().clear();
        getModes().addAll((Collection<? extends Mode>)newValue);
        return;
      case MdslPackage.SYSTEM__DISTRIBUTION:
        setDistribution((String)newValue);
        return;
      case MdslPackage.SYSTEM__RELEASE_DATE:
        setReleaseDate((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MdslPackage.SYSTEM__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MdslPackage.SYSTEM__MODES:
        getModes().clear();
        return;
      case MdslPackage.SYSTEM__DISTRIBUTION:
        setDistribution(DISTRIBUTION_EDEFAULT);
        return;
      case MdslPackage.SYSTEM__RELEASE_DATE:
        setReleaseDate(RELEASE_DATE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MdslPackage.SYSTEM__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MdslPackage.SYSTEM__MODES:
        return modes != null && !modes.isEmpty();
      case MdslPackage.SYSTEM__DISTRIBUTION:
        return DISTRIBUTION_EDEFAULT == null ? distribution != null : !DISTRIBUTION_EDEFAULT.equals(distribution);
      case MdslPackage.SYSTEM__RELEASE_DATE:
        return RELEASE_DATE_EDEFAULT == null ? releaseDate != null : !RELEASE_DATE_EDEFAULT.equals(releaseDate);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", distribution: ");
    result.append(distribution);
    result.append(", releaseDate: ");
    result.append(releaseDate);
    result.append(')');
    return result.toString();
  }

} //SystemImpl
