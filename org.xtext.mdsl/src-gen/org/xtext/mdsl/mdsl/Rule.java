/**
 * generated by Xtext 2.25.0
 */
package org.xtext.mdsl.mdsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.mdsl.mdsl.Rule#getDescription <em>Description</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.Rule#getIf <em>If</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.Rule#getCurrentMode <em>Current Mode</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.Rule#getModes <em>Modes</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.Rule#getThen <em>Then</em>}</li>
 *   <li>{@link org.xtext.mdsl.mdsl.Rule#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see org.xtext.mdsl.mdsl.MdslPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends Declaration
{
  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.xtext.mdsl.mdsl.MdslPackage#getRule_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.xtext.mdsl.mdsl.Rule#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>If</b></em>' reference list.
   * The list contents are of type {@link org.xtext.mdsl.mdsl.Event}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>If</em>' reference list.
   * @see org.xtext.mdsl.mdsl.MdslPackage#getRule_If()
   * @model
   * @generated
   */
  EList<Event> getIf();

  /**
   * Returns the value of the '<em><b>Current Mode</b></em>' reference list.
   * The list contents are of type {@link org.xtext.mdsl.mdsl.Mode}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Current Mode</em>' reference list.
   * @see org.xtext.mdsl.mdsl.MdslPackage#getRule_CurrentMode()
   * @model
   * @generated
   */
  EList<Mode> getCurrentMode();

  /**
   * Returns the value of the '<em><b>Modes</b></em>' reference list.
   * The list contents are of type {@link org.xtext.mdsl.mdsl.Mode}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modes</em>' reference list.
   * @see org.xtext.mdsl.mdsl.MdslPackage#getRule_Modes()
   * @model
   * @generated
   */
  EList<Mode> getModes();

  /**
   * Returns the value of the '<em><b>Then</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' reference.
   * @see #setThen(Mode)
   * @see org.xtext.mdsl.mdsl.MdslPackage#getRule_Then()
   * @model
   * @generated
   */
  Mode getThen();

  /**
   * Sets the value of the '{@link org.xtext.mdsl.mdsl.Rule#getThen <em>Then</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' reference.
   * @see #getThen()
   * @generated
   */
  void setThen(Mode value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' reference.
   * @see #setElse(Mode)
   * @see org.xtext.mdsl.mdsl.MdslPackage#getRule_Else()
   * @model
   * @generated
   */
  Mode getElse();

  /**
   * Sets the value of the '{@link org.xtext.mdsl.mdsl.Rule#getElse <em>Else</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Mode value);

} // Rule