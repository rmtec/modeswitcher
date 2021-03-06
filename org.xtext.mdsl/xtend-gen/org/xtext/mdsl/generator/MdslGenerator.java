/**
 * generated by Xtext 2.25.0
 */
package org.xtext.mdsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.mdsl.mdsl.Action;
import org.xtext.mdsl.mdsl.ActionWithParams;
import org.xtext.mdsl.mdsl.Mode;
import org.xtext.mdsl.mdsl.Model;
import org.xtext.mdsl.mdsl.SUPPORTED_DISTRIBUTIONS;
import org.xtext.mdsl.mdsl.Service;
import org.xtext.mdsl.mdsl.Software;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class MdslGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final Model model = ((Model) _head);
    final String targetLanguage = "java";
    if (targetLanguage != null) {
      switch (targetLanguage) {
        default:
          fsa.generateFile("SystemConfigurationCreator.java", this.generateJavaSystemConfigurationCreator(model));
          break;
      }
    } else {
      fsa.generateFile("SystemConfigurationCreator.java", this.generateJavaSystemConfigurationCreator(model));
    }
  }
  
  /**
   * def generateShellscriptSystemConfiguration(Model model) {'''
   * shellscript
   * '''
   * }
   * 
   * def generateAnsibleSystemConfiguration(Model model) {'''
   * ansible
   * '''
   * }
   */
  public CharSequence generateJavaSystemConfigurationCreator(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class SystemConfigurationCreator{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static SystemConfiguration create() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("List<Mode> modes  = new ArrayList<Mode>();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("List<Software> software = new ArrayList<Software>();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String debianRelease;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String releaseDate;");
    _builder.newLine();
    {
      Iterable<org.xtext.mdsl.mdsl.System> _filter = Iterables.<org.xtext.mdsl.mdsl.System>filter(model.getDeclarations(), org.xtext.mdsl.mdsl.System.class);
      for(final org.xtext.mdsl.mdsl.System sys : _filter) {
        _builder.append("\t\t\t");
        _builder.append("debianRelease = \"");
        String _string = sys.getDistribution().toString();
        _builder.append(_string, "\t\t\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      Iterable<Software> _filter_1 = Iterables.<Software>filter(model.getDeclarations(), Software.class);
      for(final Software s : _filter_1) {
        {
          String _package = s.getPackage();
          boolean _tripleNotEquals = (_package != null);
          if (_tripleNotEquals) {
            _builder.append("\t\t\t");
            _builder.append("Software ");
            String _firstLower = StringExtensions.toFirstLower(s.getName());
            _builder.append(_firstLower, "\t\t\t");
            _builder.append(" = new Software(\"");
            String _package_1 = s.getPackage();
            _builder.append(_package_1, "\t\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t\t");
            _builder.append("Software ");
            String _firstLower_1 = StringExtensions.toFirstLower(s.getName());
            _builder.append(_firstLower_1, "\t\t\t");
            _builder.append(" = new Software(\"");
            String _name = s.getName();
            _builder.append(_name, "\t\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("software.add(");
        String _firstLower_2 = StringExtensions.toFirstLower(s.getName());
        _builder.append(_firstLower_2, "\t\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      Iterable<Action> _filter_2 = Iterables.<Action>filter(model.getDeclarations(), Action.class);
      for(final Action a : _filter_2) {
        _builder.append("\t\t\t");
        {
          Action _superAction = a.getSuperAction();
          boolean _tripleNotEquals_1 = (_superAction != null);
          if (_tripleNotEquals_1) {
            a.setShellCmd(a.getSuperAction().getShellCmd());
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        final Procedure2<String, Integer> _function = (String param, Integer index) -> {
          a.setShellCmd(a.getShellCmd().replace(("$" + index), param));
        };
        IterableExtensions.<String>forEach(a.getParams(), _function);
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("Action ");
        String _firstLower_3 = StringExtensions.toFirstLower(a.getName());
        _builder.append(_firstLower_3, "\t\t\t");
        _builder.append(" = new Action(\"\", \"");
        String _shellCmd = a.getShellCmd();
        _builder.append(_shellCmd, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      Iterable<Service> _filter_3 = Iterables.<Service>filter(model.getDeclarations(), Service.class);
      for(final Service s_1 : _filter_3) {
        _builder.append("\t\t\t");
        _builder.append("Service ");
        String _firstLower_4 = StringExtensions.toFirstLower(s_1.getName());
        _builder.append(_firstLower_4, "\t\t\t");
        _builder.append(" = new Service(\"");
        String _name_1 = s_1.getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("Arrays.asList(");
        final Function1<Software, String> _function_1 = (Software it) -> {
          return StringExtensions.toFirstLower(it.getName());
        };
        String _join = IterableExtensions.join(ListExtensions.<Software, String>map(s_1.getUsesSoftware(), _function_1), ", ");
        _builder.append(_join, "\t\t\t\t");
        _builder.append("),");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("Arrays.asList(");
        final Function1<ActionWithParams, String> _function_2 = (ActionWithParams it) -> {
          return it.getAction().getName().concat(".withParams(\"").concat(IterableExtensions.join(it.getParams(), "\", \"")).concat("\")");
        };
        String _join_1 = IterableExtensions.join(ListExtensions.<ActionWithParams, String>map(s_1.getStartActions(), _function_2), ", ");
        _builder.append(_join_1, "\t\t\t\t");
        _builder.append("),");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("Arrays.asList(");
        final Function1<ActionWithParams, String> _function_3 = (ActionWithParams it) -> {
          return it.getAction().getName().concat(".withParams(\"").concat(IterableExtensions.join(it.getParams(), "\", \"")).concat("\")");
        };
        String _join_2 = IterableExtensions.join(ListExtensions.<ActionWithParams, String>map(s_1.getStopActions(), _function_3), ", ");
        _builder.append(_join_2, "\t\t\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(");");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      Iterable<Mode> _filter_4 = Iterables.<Mode>filter(model.getDeclarations(), Mode.class);
      for(final Mode m : _filter_4) {
        _builder.append("\t\t\t");
        _builder.append("Mode ");
        String _firstLower_5 = StringExtensions.toFirstLower(m.getName());
        _builder.append(_firstLower_5, "\t\t\t");
        _builder.append(" = new Mode(\"");
        String _firstLower_6 = StringExtensions.toFirstLower(m.getName());
        _builder.append(_firstLower_6, "\t\t\t");
        _builder.append("\",\"");
        String _description = m.getDescription();
        _builder.append(_description, "\t\t\t");
        _builder.append("\", ");
        int _priority = m.getPriority();
        _builder.append(_priority, "\t\t\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("Arrays.asList(");
        {
          Mode _superMode = m.getSuperMode();
          boolean _tripleNotEquals_2 = (_superMode != null);
          if (_tripleNotEquals_2) {
            final Function1<Service, String> _function_4 = (Service it) -> {
              return StringExtensions.toFirstLower(it.getName());
            };
            String _join_3 = IterableExtensions.join(ListExtensions.<Service, String>map(m.getSuperMode().getStartServices(), _function_4), ", ");
            _builder.append(_join_3, "\t\t\t\t");
            {
              EList<Service> _startServices = m.getStartServices();
              boolean _tripleNotEquals_3 = (_startServices != null);
              if (_tripleNotEquals_3) {
                _builder.append(",");
              }
            }
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        final Function1<Service, String> _function_5 = (Service it) -> {
          return StringExtensions.toFirstLower(it.getName());
        };
        String _join_4 = IterableExtensions.join(ListExtensions.<Service, String>map(m.getStartServices(), _function_5), ", ");
        _builder.append(_join_4, "\t\t\t\t");
        _builder.append("),");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("Arrays.asList(");
        {
          Mode _superMode_1 = m.getSuperMode();
          boolean _tripleNotEquals_4 = (_superMode_1 != null);
          if (_tripleNotEquals_4) {
            final Function1<Service, String> _function_6 = (Service it) -> {
              return StringExtensions.toFirstLower(it.getName());
            };
            String _join_5 = IterableExtensions.join(ListExtensions.<Service, String>map(m.getSuperMode().getStopServices(), _function_6), ", ");
            _builder.append(_join_5, "\t\t\t\t");
            {
              EList<Service> _stopServices = m.getStopServices();
              boolean _tripleNotEquals_5 = (_stopServices != null);
              if (_tripleNotEquals_5) {
                _builder.append(",");
              }
            }
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        final Function1<Service, String> _function_7 = (Service it) -> {
          return StringExtensions.toFirstLower(it.getName());
        };
        String _join_6 = IterableExtensions.join(ListExtensions.<Service, String>map(m.getStopServices(), _function_7), ", ");
        _builder.append(_join_6, "\t\t\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append(");");
        _builder.newLine();
        {
          if (((m.getEnabled() != null) && Objects.equal(m.getEnabled(), Boolean.valueOf(false)))) {
            _builder.append("\t\t\t");
            String _firstLower_7 = StringExtensions.toFirstLower(m.getName());
            _builder.append(_firstLower_7, "\t\t\t");
            _builder.append(".setEnabled(false);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("modes.add(");
        String _firstLower_8 = StringExtensions.toFirstLower(m.getName());
        _builder.append(_firstLower_8, "\t\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      Iterable<Mode> _filter_5 = Iterables.<Mode>filter(model.getDeclarations(), Mode.class);
      for(final Mode m_1 : _filter_5) {
        {
          EList<Mode> _alternativeModes = m_1.getAlternativeModes();
          boolean _tripleNotEquals_6 = (_alternativeModes != null);
          if (_tripleNotEquals_6) {
            _builder.append("\t\t\t");
            String _firstLower_9 = StringExtensions.toFirstLower(m_1.getName());
            _builder.append(_firstLower_9, "\t\t\t");
            _builder.append(".setAlternativeModes(Arrays.asList(");
            final Function1<Mode, String> _function_8 = (Mode it) -> {
              return StringExtensions.toFirstLower(it.getName());
            };
            String _join_7 = IterableExtensions.join(ListExtensions.<Mode, String>map(m_1.getAlternativeModes(), _function_8), ", ");
            _builder.append(_join_7, "\t\t\t");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return new SystemConfiguration(modes, software);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public Object getReleaseDate(final org.xtext.mdsl.mdsl.System s) {
    return this.getReleaseDate(s);
  }
  
  public SUPPORTED_DISTRIBUTIONS getDistribution(final org.xtext.mdsl.mdsl.System s) {
    return s.getDistribution();
  }
}
