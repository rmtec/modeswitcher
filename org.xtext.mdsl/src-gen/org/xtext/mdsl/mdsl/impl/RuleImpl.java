/**
 * generated by Xtext 2.25.0
 */
package org.xtext.mdsl.mdsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.xtext.mdsl.mdsl.Event;
import org.xtext.mdsl.mdsl.MdslPackage;
import org.xtext.mdsl.mdsl.Mode;
import org.xtext.mdsl.mdsl.Rule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.RuleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.RuleImpl#getIf <em>If</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.RuleImpl#getCurrentMode <em>Current Mode</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.RuleImpl#getModes <em>Modes</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.RuleImpl#getThen <em>Then</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.RuleImpl#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleImpl extends DeclarationImpl implements Rule
{
  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getIf() <em>If</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIf()
   * @generated
   * @ordered
   */
  protected EList<Event> if_;

  /**
   * The cached value of the '{@link #getCurrentMode() <em>Current Mode</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCurrentMode()
   * @generated
   * @ordered
   */
  protected EList<Mode> currentMode;

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
   * The cached value of the '{@link #getThen() <em>Then</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThen()
   * @generated
   * @ordered
   */
  protected Mode then;

  /**
   * The cached value of the '{@link #getElse() <em>Else</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElse()
   * @generated
   * @ordered
   */
  protected Mode else_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleImpl()
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
    return MdslPackage.Literals.RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.RULE__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Event> getIf()
  {
    if (if_ == null)
    {
      if_ = new EObjectResolvingEList<Event>(Event.class, this, MdslPackage.RULE__IF);
    }
    return if_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Mode> getCurrentMode()
  {
    if (currentMode == null)
    {
      currentMode = new EObjectResolvingEList<Mode>(Mode.class, this, MdslPackage.RULE__CURRENT_MODE);
    }
    return currentMode;
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
      modes = new EObjectResolvingEList<Mode>(Mode.class, this, MdslPackage.RULE__MODES);
    }
    return modes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Mode getThen()
  {
    if (then != null && then.eIsProxy())
    {
      InternalEObject oldThen = (InternalEObject)then;
      then = (Mode)eResolveProxy(oldThen);
      if (then != oldThen)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdslPackage.RULE__THEN, oldThen, then));
      }
    }
    return then;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mode basicGetThen()
  {
    return then;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setThen(Mode newThen)
  {
    Mode oldThen = then;
    then = newThen;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.RULE__THEN, oldThen, then));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Mode getElse()
  {
    if (else_ != null && else_.eIsProxy())
    {
      InternalEObject oldElse = (InternalEObject)else_;
      else_ = (Mode)eResolveProxy(oldElse);
      if (else_ != oldElse)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdslPackage.RULE__ELSE, oldElse, else_));
      }
    }
    return else_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mode basicGetElse()
  {
    return else_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setElse(Mode newElse)
  {
    Mode oldElse = else_;
    else_ = newElse;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.RULE__ELSE, oldElse, else_));
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
      case MdslPackage.RULE__DESCRIPTION:
        return getDescription();
      case MdslPackage.RULE__IF:
        return getIf();
      case MdslPackage.RULE__CURRENT_MODE:
        return getCurrentMode();
      case MdslPackage.RULE__MODES:
        return getModes();
      case MdslPackage.RULE__THEN:
        if (resolve) return getThen();
        return basicGetThen();
      case MdslPackage.RULE__ELSE:
        if (resolve) return getElse();
        return basicGetElse();
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
      case MdslPackage.RULE__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case MdslPackage.RULE__IF:
        getIf().clear();
        getIf().addAll((Collection<? extends Event>)newValue);
        return;
      case MdslPackage.RULE__CURRENT_MODE:
        getCurrentMode().clear();
        getCurrentMode().addAll((Collection<? extends Mode>)newValue);
        return;
      case MdslPackage.RULE__MODES:
        getModes().clear();
        getModes().addAll((Collection<? extends Mode>)newValue);
        return;
      case MdslPackage.RULE__THEN:
        setThen((Mode)newValue);
        return;
      case MdslPackage.RULE__ELSE:
        setElse((Mode)newValue);
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
      case MdslPackage.RULE__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case MdslPackage.RULE__IF:
        getIf().clear();
        return;
      case MdslPackage.RULE__CURRENT_MODE:
        getCurrentMode().clear();
        return;
      case MdslPackage.RULE__MODES:
        getModes().clear();
        return;
      case MdslPackage.RULE__THEN:
        setThen((Mode)null);
        return;
      case MdslPackage.RULE__ELSE:
        setElse((Mode)null);
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
      case MdslPackage.RULE__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case MdslPackage.RULE__IF:
        return if_ != null && !if_.isEmpty();
      case MdslPackage.RULE__CURRENT_MODE:
        return currentMode != null && !currentMode.isEmpty();
      case MdslPackage.RULE__MODES:
        return modes != null && !modes.isEmpty();
      case MdslPackage.RULE__THEN:
        return then != null;
      case MdslPackage.RULE__ELSE:
        return else_ != null;
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
    result.append(" (description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //RuleImpl
