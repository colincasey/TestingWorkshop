package multithreading;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class NameTag extends TagSupport {
    private static final long serialVersionUID = -7280661464328893136L;
    private ThreadLocal<String> name = new ThreadLocal<String>();

    public String getName() {
        return this.name.get();
    }

    public void setName(String name) {
        this.name.set(name);
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
