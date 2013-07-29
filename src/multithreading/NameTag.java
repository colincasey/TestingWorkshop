package multithreading;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class NameTag extends TagSupport {
    private static final long serialVersionUID = -7280661464328893136L;
    private static final String NAME_KEY = "name";

    public String getName() {
        return (String) this.getValue(NAME_KEY);
    }

    public void setName(String name) {
        this.setValue(NAME_KEY, name);
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            this.pageContext.getOut().write(getName() + "\n");
        } catch (IOException e) {
            throw new JspException(e.getMessage(), e);
        }
        return SKIP_BODY;
    }
}
