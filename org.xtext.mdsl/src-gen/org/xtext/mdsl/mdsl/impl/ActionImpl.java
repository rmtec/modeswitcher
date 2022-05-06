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

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.xtext.mdsl.mdsl.Action;
import org.xtext.mdsl.mdsl.MdslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.ActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.ActionImpl#getSuperAction <em>Super Action</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.ActionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.ActionImpl#getShellCmd <em>Shell Cmd</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.impl.ActionImpl#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionImpl extends DeclarationImpl implements Action
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
   * The cached value of the '{@link #getSuperAction() <em>Super Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperAction()
   * @generated
   * @ordered
   */
  protected Action superAction;

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
   * The default value of the '{@link #getShellCmd() <em>Shell Cmd</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShellCmd()
   * @generated
   * @ordered
   */
  protected static final String SHELL_CMD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShellCmd() <em>Shell Cmd</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShellCmd()
   * @generated
   * @ordered
   */
  protected String shellCmd = SHELL_CMD_EDEFAULT;

  /**
   * The cached value of the '{@link #getParams() <em>Params</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParams()
   * @generated
   * @ordered
   */
  protected EList<String> params;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActionImpl()
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
    return MdslPackage.Literals.ACTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.ACTION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Action getSuperAction()
  {
    if (superAction != null && superAction.eIsProxy())
    {
      InternalEObject oldSuperAction = (InternalEObject)superAction;
      superAction = (Action)eResolveProxy(oldSuperAction);
      if (superAction != oldSuperAction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MdslPackage.ACTION__SUPER_ACTION, oldSuperAction, superAction));
      }
    }
    return superAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action basicGetSuperAction()
  {
    return superAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSuperAction(Action newSuperAction)
  {
    Action oldSuperAction = superAction;
    superAction = newSuperAction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.ACTION__SUPER_ACTION, oldSuperAction, superAction));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.ACTION__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getShellCmd()
  {
    return shellCmd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setShellCmd(String newShellCmd)
  {
    String oldShellCmd = shellCmd;
    shellCmd = newShellCmd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdslPackage.ACTION__SHELL_CMD, oldShellCmd, shellCmd));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getParams()
  {
    if (params == null)
    {
      params = new EDataTypeEList<String>(String.class, this, MdslPackage.ACTION__PARAMS);
    }
    return params;
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
      case MdslPackage.ACTION__NAME:
        return getName();
      case MdslPackage.ACTION__SUPER_ACTION:
        if (resolve) return getSuperAction();
        return basicGetSuperAction();
      case MdslPackage.ACTION__DESCRIPTION:
        return getDescription();
      case MdslPackage.ACTION__SHELL_CMD:
        return getShellCmd();
      case MdslPackage.ACTION__PARAMS:
        return getParams();
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
      case MdslPackage.ACTION__NAME:
        setName((String)newValue);
        return;
      case MdslPackage.ACTION__SUPER_ACTION:
        setSuperAction((Action)newValue);
        return;
      case MdslPackage.ACTION__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case MdslPackage.ACTION__SHELL_CMD:
        setShellCmd((String)newValue);
        return;
      case MdslPackage.ACTION__PARAMS:
        getParams().clear();
        getParams().addAll((Collection<? extends String>)newValue);
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
      case MdslPackage.ACTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MdslPackage.ACTION__SUPER_ACTION:
        setSuperAction((Action)null);
        return;
      case MdslPackage.ACTION__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case MdslPackage.ACTION__SHELL_CMD:
        setShellCmd(SHELL_CMD_EDEFAULT);
        return;
      case MdslPackage.ACTION__PARAMS:
        getParams().clear();
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
      case MdslPackage.ACTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MdslPackage.ACTION__SUPER_ACTION:
        return superAction != null;
      case MdslPackage.ACTION__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case MdslPackage.ACTION__SHELL_CMD:
        return SHELL_CMD_EDEFAULT == null ? shellCmd != null : !SHELL_CMD_EDEFAULT.equals(shellCmd);
      case MdslPackage.ACTION__PARAMS:
        return params != null && !params.isEmpty();
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
    result.append(", description: ");
    result.append(description);
    result.append(", shellCmd: ");
    result.append(shellCmd);
    result.append(", params: ");
    result.append(params);
    result.append(')');
    return result.toString();
  }

} //ActionImpl
